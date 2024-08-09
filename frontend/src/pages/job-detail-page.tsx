import { useState } from "react";
import { JobListingType } from "../types/types";
import { Box, Button, Paper, Typography } from "@mui/material";

const JobDetailsPage = () => {
  const [job, setJob] = useState<JobListingType>();
  return (
    <Box>
      <Paper>
        <Typography>{job?.company}</Typography>
        <Typography>{job?.company}</Typography>
        <Button sx={{ width: "147px", height: "48px" }}>{job?.company}</Button>
      </Paper>
      JobDetailsPage
    </Box>
  );
};

export default JobDetailsPage;
