import { useState } from "react";
import {
  Button,
  FormControl,
  FormControlLabel,
  FormLabel,
  Link,
  Radio,
  RadioGroup,
  Stack,
  TextField,
} from "@mui/material";
import {
  applicantRegistration,
  employerRegistration,
} from "../apiService/services/auth";

type Props = {
  setIsRegistering: (value: boolean) => void;
};
const Register = ({ setIsRegistering }: Props) => {
  const initialState = {
    firstName: "",
    lastName: "",
    email: "",
    password: "",
  };
  const [state, setState] = useState(initialState);
  const [radioButtonState, setRadioButtonState] = useState("applicant");

  const handleOnChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setState({ ...state, [e.target.name]: e.target.value });
  };

  const handleRegistration = async (e: any) => {
    e.preventDefault();
    try {
      if (radioButtonState === "applicant") {
        await applicantRegistration(state);
      } else {
        await employerRegistration(state);
      }
      setState(initialState);
      setIsRegistering(false);
    } catch (error) {
      console.log("Error: ", error);
    }
  };

  return (
    <FormControl sx={{ width: "50%" }}>
      <TextField
        label={"First Name"}
        id="normal"
        name="firstName"
        value={state.firstName}
        onChange={handleOnChange}
      />

      <TextField
        label={"Last Name"}
        id="margin-dense"
        margin="normal"
        name="lastName"
        value={state.lastName}
        onChange={handleOnChange}
      />

      <TextField
        label={"Email"}
        id="margin-normal"
        margin="normal"
        name="email"
        value={state.email}
        onChange={handleOnChange}
      />
      <TextField
        label={"Password"}
        id="margin-normal"
        margin="normal"
        name="password"
        type="password"
        value={state.password}
        onChange={handleOnChange}
      />
      <Stack direction="column" spacing={1} sx={{ mt: "15px" }}>
        <FormLabel
          id="demo-controlled-radio-buttons-group"
          sx={{ color: "#5964E0" }}
        >
          Register As:
        </FormLabel>
        <RadioGroup
          aria-labelledby="demo-controlled-radio-buttons-group"
          name="controlled-radio-buttons-group"
          sx={{
            flexDirection: "row",
          }}
          value={radioButtonState}
          onChange={(e) => setRadioButtonState(e.target.value)}
        >
          <FormControlLabel
            value="applicant"
            control={<Radio />}
            label="Applicant"
          />
          <FormControlLabel
            value="employer"
            control={<Radio />}
            label="Employer"
          />
        </RadioGroup>
      </Stack>
      <Stack
        direction="column"
        spacing={1}
        sx={{ mt: "15px", minWidth: "35%", alignSelf: "center" }}
      >
        <span>
          Already have an account?
          <Link
            component="button"
            variant="body1"
            onClick={() => setIsRegistering(false)}
            sx={{ ml: "5px" }}
          >
            Login
          </Link>
        </span>

        <Button
          onClick={(e) => handleRegistration(e)}
          variant="contained"
          sx={{ bgcolor: "#5964E0", color: "white", width: "50%" }}
        >
          Register
        </Button>
      </Stack>
    </FormControl>
  );
};

export default Register;
