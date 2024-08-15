import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Button, FormControl, Stack, TextField } from "@mui/material";
import { login } from "../apiService/services/auth";

const Login = () => {
  const initialState = {
    email: "",
    password: "",
  };
  const [state, setState] = useState(initialState);
  const navigate = useNavigate();

  const handleOnChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setState({ ...state, [e.target.name]: e.target.value });
  };

  const handleLogin = async (e: any) => {
    e.preventDefault();
    try {
      await login(state);
      setState(initialState);
      navigate("/job-listings");
    } catch (error) {
      console.log("Error: ", error);
    }
  };

  return (
    <FormControl sx={{ width: "50%" }}>
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
      <Stack
        direction="column"
        spacing={1}
        sx={{ mt: "15px", minWidth: "35%", alignSelf: "center" }}
      >
        <Button
          variant="contained"
          sx={{ bgcolor: "#5964E0", color: "white", width: "50%" }}
          onClick={(e) => handleLogin(e)}
        >
          Login
        </Button>
      </Stack>
    </FormControl>
  );
};

export default Login;
