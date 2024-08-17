import apiClient from "../setup/axios";


type JobListing = {
  jobTitle: string,
  location: string
  yearsOfExperience: number,
  jobSalary: number,
  employer: {
    employerName: string
    employerInfo: string,
  },
  requireTechnicalSkills: string[],
  requireSoftSkills: string[],
  benefits: string[],
};

export const getAllJobs = async () => {
    const response = await apiClient.get("/api/v1/jobs");
    return response.data;
  };


export const createJob = async (data:JobListing) => {
  const response = await apiClient.post("/api/v1/jobs", data);
  return response.data;
};

export const getAllEmployerJobs = async (employerId:number) => {
  const response =  await apiClient.get(`/api/v1/jobs/employers/${employerId}`);
  return response.data;
}