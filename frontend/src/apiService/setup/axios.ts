import axios, { AxiosError, AxiosResponse } from 'axios';
import {getUser} from './user';

const apiClient = axios.create({
  baseURL: 'http://localhost:8077/',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json;charset=UTF-8'
  }
});

  // TODO: Modify this base on the backend implementation
const getAccessToken = () => getUser().user;

// Request interceptor to add the access token to headers
apiClient.interceptors.request.use(
  config => {
   
    const configUrl = config.url?.startsWith("/register") || config.url?.startsWith("/login")
    const token = getAccessToken() && JSON.parse(getAccessToken()).token;
    if (token !== '' && token != null && token.length > 0 && !configUrl) {
      config.headers['Authorization'] = `Bearer ${token}`;
    } else {
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
      console.log("Access Denied");
    }

    return Promise.reject(error);
  }
);

export default apiClient;