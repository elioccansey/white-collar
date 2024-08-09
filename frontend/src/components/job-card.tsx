import { Box, Paper, Typography } from "@mui/material";
import { JobListingType } from "../types/types";
import { Link } from "react-router-dom";

type JobCardProps = JobListingType;

const JobCard = ({ company, salary, title, location, id }: JobCardProps) => {
  return (
    <Paper
      elevation={0}
      sx={{
        p: "2.0625rem",
        width: { xs: "20.4375rem", sm: "21.1875rem", md: "21.875rem" },
        mt: "30px",
      }}
    >
      <Link to={`joblistings/${id}`} style={{ textDecoration: "none" }}>
        <Box>
          <Typography
            sx={{
              color: "#6E8098",
            }}
          >
            {company}
          </Typography>

          <Typography
            sx={{
              color: "#19202D",
              marginTop: "12px",
              fontWeight: "bold",
              fontSize: "20px",
            }}
          >
            {title}
          </Typography>
          <Typography
            sx={{
              color: "#6E8098",
              marginTop: "12px",
            }}
          >
            {`$${salary}`}
          </Typography>
          <Typography
            sx={{
              color: "#5964E0",
              marginTop: "40px",
            }}
          >
            {location}
          </Typography>
        </Box>
      </Link>
    </Paper>
  );
};

export default JobCard;
