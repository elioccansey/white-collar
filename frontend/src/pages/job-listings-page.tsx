import { styled } from "@mui/material";
import JobListings from "../components/job-listing";
const JobListingsPage = () => {
  return (
    <Wrapper>
      <JobListings />
    </Wrapper>
  );
};

export default JobListingsPage;

const Wrapper = styled("main")({
  backgroundColor: "#F4F6F8",
  display: "flex",
  alignItems: "center",
  flexDirection: "column",
});
