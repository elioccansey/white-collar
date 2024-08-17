import { Box } from "@mui/material";
import jobListingsData from "../data";
import JobCard from "./job-card";
import SearchBar from "./search-bar";
import { useEffect, useState } from "react";
import { getAllEmployerJobs } from "../apiService/services/jobs";
import { getUser } from "../apiService/setup/user";
import BusinessIcon from "@mui/icons-material/Business";

const EmployerJobListings = () => {
  const [state, setState] = useState();
  const profile = JSON.parse(getUser().user);

  useEffect(() => {
    getEmployerJobs();
  }, []);

  const getEmployerJobs = async () => {
    try {
      const result = await getAllEmployerJobs(profile.user.userId);
      setState(result);
    } catch (error) {
      console.log("error:", error);
    }
  };

  console.log("results---employer", state);
  return (
    <Box
      sx={{
        maxWidth: "1440px",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
      }}
    >
      <SearchBar />
      <Box
        sx={{
          display: "flex",
          gap: { md: "11px" },
          flexWrap: "wrap",
          justifyContent: "center",
        }}
      >
        {jobListingsData.map(
          ({
            id,
            company,
            location,
            salary,
            logoURL,
            publishedDate,
            title,
          }) => (
            <JobCard
              salary={salary}
              id={id}
              company={company}
              logoURL={logoURL}
              publishedDate={publishedDate}
              title={title}
              key={id}
              location={location}
            />
          )
        )}
      </Box>
    </Box>
  );
};

export default EmployerJobListings;
