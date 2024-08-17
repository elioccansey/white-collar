import apiClient from "../setup/axios";
import { setUser } from "../setup/user";

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
    if (res.status === 201) {
        const {data} = res;
        setUser({
            token: data.token,
            user: {
                userId: data.userId,
                firstName: data.firstName,
                lastName: data.lastName,
                role: data.role[0].name
            }
        });
    } else {
        console.log("Something went wrong. Please try again later.")
    }
}