import { Button, styled } from "@mui/material";
import { useState } from "react";
import CreateJobForm from "../components/create-job-form";
import EmployerJobListings from "../components/employer-job-listings";

const EmployerJobListingsPage = () => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  return (
    <Wrapper>
      <Button
        variant="outlined"
        onClick={handleOpen}
        sx={{
          m: "30px 10px 0 0",
          alignSelf: "end",
          textTransform: "capitalize",
        }}
      >
        Add Job listing
      </Button>

      <EmployerJobListings />
      <CreateJobForm open={open} onClose={handleClose} />
    </Wrapper>
  );
};

export default EmployerJobListingsPage;

const Wrapper = styled("main")({
  backgroundColor: "#F4F6F8",
  display: "flex",
  alignItems: "center",
  flexDirection: "column",
});
