package com.pb.riskanalysisforsmb;

import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.core.HttpHeaders;

public final class RestRequest {
    private static final String TAG = "RestRequest";
    private final static String SERVER_ERROR_MSG = "Server returned status code: ";


    private RestRequest() {
    }


    public static String executeGetRequest(String urlString, String authToken) {
        HttpsURLConnection restHttpsConnection = null;
        HttpURLConnection restHttpConnection = null;
        String jsonResponse = null;
        try {
            URL url = new URL(urlString);

            if ("https".equals(url.getProtocol())) {
                restHttpsConnection = (HttpsURLConnection) url.openConnection();
                restHttpsConnection.setRequestProperty("Authorization", authToken);
                jsonResponse = getResponse(restHttpsConnection);
            } else if ("http".equals(url.getProtocol())) {
                restHttpConnection = (HttpURLConnection) url.openConnection();
                restHttpConnection.setRequestProperty("Authorization", authToken);
                jsonResponse = getHttpResponse(restHttpConnection);
            }
        } catch (Exception e) {
            Log.i(TAG, "Exception in executeGetRequest " + Log.getStackTraceString(e));
        } finally {
            if (restHttpsConnection != null) {
                restHttpsConnection.disconnect();
            }
            if (restHttpConnection != null) {
                restHttpConnection.disconnect();
            }
        }
        return jsonResponse;
    }


    public static String executePostRequest(String urlString, String authToken, String postData, String contentType) {

        HttpsURLConnection restConnection = null;

        try {
            URL url = new URL(urlString);
            restConnection = (HttpsURLConnection) url.openConnection();
            restConnection.setRequestProperty("Authorization", authToken);
            restConnection.setRequestMethod("POST");
            restConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, contentType);
            restConnection.setDoOutput(true);
            restConnection.getOutputStream().write(postData.getBytes());
        } catch (IOException e) {
            Log.i(TAG, "Exception in executePostRequest " + Log.getStackTraceString(e));
        } finally {
            if (restConnection != null) {
                restConnection.disconnect();
            }
        }

        return getResponse(restConnection);
    }


    private static String getResponse(HttpsURLConnection restConnection) {
        try {
            int statusCode = restConnection.getResponseCode();
            if (statusCode == 200) {
                InputStream responseBody = restConnection.getInputStream();
                return IOUtils.toString(responseBody);
            } else {
                // Error handling code goes here
                throw new RuntimeException(SERVER_ERROR_MSG + statusCode + ", Response: " + restConnection.getContent());

            }
        } catch (IOException e) {
            Log.i(TAG, "Exception in executeGetRequest " + Log.getStackTraceString(e));
        } finally {
            if (restConnection != null) {
                restConnection.disconnect();
            }
        }
        return null;
    }


    private static String getHttpResponse(HttpURLConnection restConnection) {
        try {
            int statusCode = restConnection.getResponseCode();
            if (statusCode == 200) {
                InputStream responseBody = restConnection.getInputStream();
                return IOUtils.toString(responseBody);
            } else {
                // Error handling code goes here
                throw new RuntimeException(SERVER_ERROR_MSG + statusCode + ", Response: " + restConnection.getContent());

            }
        } catch (IOException e) {
            Log.i(TAG, "Exception in executeGetRequest " + Log.getStackTraceString(e));
        } finally {
            if (restConnection != null) {
                restConnection.disconnect();
            }
        }
        return null;
    }

    /**
     * Implements HTTP's GET method
     */
    public static String httpGET(String requestAddress) {
        URL request;
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        String tmpStr;
        String response = null;

        try {
            request = new URL(requestAddress);
            connection = (HttpURLConnection) request.openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String encoding = connection.getContentEncoding();

                try {
                    if (encoding != null && "gzip".equalsIgnoreCase(encoding)) {
                        reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream())));
                    } else if (encoding != null && "deflate".equalsIgnoreCase(encoding)) {
                        reader = new BufferedReader(new InputStreamReader(new InflaterInputStream(connection.getInputStream(), new Inflater(true))));
                    } else {
                        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    }

                    while ((tmpStr = reader.readLine()) != null) {
                        response = tmpStr;
                    }
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                    }
                }
            } else { // if HttpURLConnection is not okay
                try {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    while ((tmpStr = reader.readLine()) != null) {
                        response = tmpStr;
                    }
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                    }
                }

                // if response is bad
                System.err.println("Bad Response: " + response + "\n");
                return null;
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            response = null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response;
    }
}
