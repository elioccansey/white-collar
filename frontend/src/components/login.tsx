import { useState } from "react";
import { Button, FormControl, Stack, TextField } from "@mui/material";

const Login = () => {
  const initialState = {
    email: "",
    password: "",
  };
  const [state, setState] = useState(initialState);

  const handleOnChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setState({ ...state, [e.target.name]: e.target.value });
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
        >
          Login
        </Button>
      </Stack>
    </FormControl>
  );
};

export default Login;
