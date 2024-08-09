import { Box } from "@mui/material";
import jobListingsData from "../data";
import JobCard from "./job-card";
import SearchBar from "./search-bar";

const JobListings = () => {
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

export default JobListings;
