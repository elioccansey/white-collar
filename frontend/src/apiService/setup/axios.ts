import axios, { AxiosError, AxiosResponse } from 'axios';
import {getTokens, setTokens} from './token';

const apiClient = axios.create({
  baseURL: 'http://localhost:8077/',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json;charset=UTF-8'
  }
});

  // TODO: Modify this base on the backend implementation
const getAccessToken = () => getTokens().accessToken;


// Request interceptor to add the access token to headers
apiClient.interceptors.request.use(
  config => {
    const token = getAccessToken();
    if (token !== '' && token != null && token.length > 0) {
      config.headers['Authorization'] = `Bearer ${token}`;
    } else {
      // config.headers['Authorization'] = null;
      delete axios.defaults.headers.common['Authorization'];
    }
    return config;
  },
  (error: AxiosError) => Promise.reject(error)
);


// Response interceptor to handle 401 errors and token refresh
apiClient.interceptors.response.use(
  (response: AxiosResponse) => response,
  async error => {

    // TODO: Modify this base on the backend implementation(if there's refresh token to fetch new token in case of expiration)
    if (error.response.status === 401) {
     console.log("There's no token");
    }

    return Promise.reject(error);
  }
);

export default apiClient;