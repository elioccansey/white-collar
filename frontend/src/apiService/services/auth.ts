import apiClient from "../setup/axios";
import { setTokens } from "../setup/token";

type Registration = {
    firstName: string,
    lastName: string,
    email: string,
    password: string,
}

type Login = {
    email: string,
    password: string,
}

export const applicantRegistration = async (data:Registration) => {
    const response = await apiClient.post("/register/applicant", data);
    return response.data;
  };

  export const employerRegistration = async (data:Registration) => {
    const response = await apiClient.post("/register/employer", data);
    return response.data;
  };

  export const login = async (data:Login) => {
    const res = await  apiClient.post(`/login?email=${data.email}&password=${data.password}`, { });

    console.log("Error: ", res.data);
    if (res.status === 201) {
        setTokens(res.data.token);
    } else {
        console.log("Something went wrong. Please try again later.")
    }
}