import apiClient from "../setup/axios";

export const getAllJobs = async () => {
    const response = await apiClient.get("/api/v1/jobs");
    return response.data;
  };