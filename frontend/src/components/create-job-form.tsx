import {
  Modal,
  Box,
  Typography,
  FormControl,
  TextField,
  Button,
  Stack,
  Divider,
  Grid,
  Autocomplete,
  Chip,
} from "@mui/material";
import React, { useState } from "react";
import { createJob } from "../apiService/services/jobs";

type Props = {
  open: boolean;
  onClose: () => void;
};

const style = {
  position: "absolute" as "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  minWidth: "55%",
  bgcolor: "background.paper",
  p: 2,
  borderRadius: "6px",
};

const CreateJobForm = ({ open, onClose }: Props) => {
  const initialState = {
    jobTitle: "",
    location: "",
    yearsOfExperience: 0,
    jobSalary: 0,
    employer: {
      employerName: "",
      employerInfo: "",
    },
  };
  const [jobDetails, setJobDetails] = useState(initialState);
  const [techSkillsTags, setTechSkillsTags] = useState<string[]>([]);
  const [softSkillsTags, setSoftSkillsTags] = useState<string[]>([]);
  const [benefitTags, setBenefitTags] = useState<string[]>([]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    setJobDetails((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleNestedChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    setJobDetails((prevState) => ({
      ...prevState,
      employer: {
        ...prevState.employer,
        [name]: value,
      },
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    const updatedState = {
      ...jobDetails,
      requireTechnicalSkills: techSkillsTags,
      requireSoftSkills: softSkillsTags,
      benefits: benefitTags,
    };

    try {
      await createJob(updatedState);
      setJobDetails(initialState);
      setTechSkillsTags([]);
      setSoftSkillsTags([]);
      setBenefitTags([]);
    } catch (error) {
      console.log("Error: ", error);
    }
  };

  const tagLabel = (title: string) => {
    return (
      <Stack direction={"row"}>
        <Typography variant="body1">{title}</Typography>
        <Typography variant="caption" sx={{ m: "3px 0 0 3px" }}>
          (Press enter to add another {title})
        </Typography>
      </Stack>
    );
  };

  return (
    <>
      <Modal
        open={open}
        onClose={onClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
        sx={{
          width: "100%",
          padding: "10px",
        }}
      >
        <Box sx={style}>
          <Typography
            id="modal-modal-title"
            variant="h6"
            component="h2"
            textAlign="center"
            sx={{ p: "15px" }}
          >
            Add new job listing
          </Typography>
          <FormControl sx={{ width: "100%" }}>
            <Grid
              container
              rowSpacing={1}
              //   columnSpacing={{ xs: 1, sm: 2, md: 3 }}
              justifyContent={"space-around"}
              sx={{
                p: "40px 19px 0px 10px",
              }}
            >
              <Stack
                direction="column"
                spacing={1}
                sx={{ minWidth: "45%", alignSelf: "center" }}
              >
                <TextField
                  label={"Job Title"}
                  id="normal"
                  name="jobTitle"
                  value={jobDetails.jobTitle}
                  onChange={handleChange}
                  sx={{ pb: "15px" }}
                />

                <TextField
                  label={"Location"}
                  id="margin-dense"
                  margin="normal"
                  name="location"
                  value={jobDetails.location}
                  onChange={handleChange}
                  sx={{ pb: "15px" }}
                />

                <TextField
                  label={"Years Of Experience"}
                  id="margin-normal"
                  margin="normal"
                  type="number"
                  name="yearsOfExperience"
                  value={jobDetails.yearsOfExperience}
                  onChange={handleChange}
                  sx={{ pb: "15px" }}
                />
                <TextField
                  label={"Job Salary"}
                  id="margin-normal"
                  margin="normal"
                  name="jobSalary"
                  type="number"
                  value={jobDetails.jobSalary}
                  onChange={handleChange}
                />
              </Stack>
              <Divider
                orientation="vertical"
                sx={{
                  bgcolor: "#5964E0",
                  margin: "0px 10px !important",
                  borderBottomWidth: "55px",
                  height: "inherit !important",
                }}
              />
              <Stack
                direction="column"
                spacing={1}
                sx={{ minWidth: "45%", alignSelf: "center" }}
              >
                <TextField
                  label={"Employer Name"}
                  id="margin-normal"
                  margin="normal"
                  name="employerName"
                  type="text"
                  value={jobDetails.employer.employerName}
                  onChange={handleNestedChange}
                  sx={{ pb: "15px" }}
                />
                <Autocomplete
                  clearIcon={false}
                  options={[]}
                  value={techSkillsTags}
                  onChange={(event: React.SyntheticEvent, newValue: string[]) =>
                    setTechSkillsTags(newValue)
                  }
                  freeSolo
                  multiple
                  renderTags={(value, props) =>
                    value.map((option, index) => (
                      <Chip label={option} {...props({ index })} />
                    ))
                  }
                  renderInput={(params) => (
                    <TextField
                      sx={{ pb: "15px" }}
                      label={tagLabel("Tech Skill")}
                      {...params}
                    />
                  )}
                />

                <Autocomplete
                  clearIcon={false}
                  options={[]}
                  value={softSkillsTags}
                  onChange={(event: React.SyntheticEvent, newValue: string[]) =>
                    setSoftSkillsTags(newValue)
                  }
                  freeSolo
                  multiple
                  renderTags={(value, props) =>
                    value.map((option, index) => (
                      <Chip label={option} {...props({ index })} />
                    ))
                  }
                  renderInput={(params) => (
                    <TextField
                      sx={{ pb: "15px" }}
                      label={tagLabel("Soft Skill")}
                      {...params}
                    />
                  )}
                />

                <Autocomplete
                  clearIcon={false}
                  options={[]}
                  value={benefitTags}
                  onChange={(event: React.SyntheticEvent, newValue: string[]) =>
                    setBenefitTags(newValue)
                  }
                  freeSolo
                  multiple
                  renderTags={(value, props) =>
                    value.map((option, index) => (
                      <Chip label={option} {...props({ index })} />
                    ))
                  }
                  renderInput={(params) => (
                    <TextField label={tagLabel("Benefits")} {...params} />
                  )}
                />
              </Stack>
              <Stack
                direction="column"
                spacing={1}
                sx={{
                  minWidth: "100%",
                  m: "30px 10px 0 10px",
                }}
              >
                <TextField
                  label={"Employer Information"}
                  id="margin-normal"
                  margin="normal"
                  name="employerInfo"
                  type="text area"
                  value={jobDetails.employer.employerInfo}
                  onChange={handleNestedChange}
                />
              </Stack>
            </Grid>
            <Stack
              direction="row"
              spacing={1}
              sx={{ m: "40px 0 20px 0", minWidth: "30%", alignSelf: "center" }}
            >
              <Button
                onClick={(e) => handleSubmit(e)}
                variant="contained"
                sx={{ bgcolor: "#5964E0", color: "white", width: "50%" }}
              >
                Submit
              </Button>
              <Button
                onClick={onClose}
                variant="contained"
                sx={{ bgcolor: "#5964E0", color: "white", width: "50%" }}
              >
                Cancel
              </Button>
            </Stack>
          </FormControl>
        </Box>
      </Modal>
    </>
  );
};

export default CreateJobForm;
