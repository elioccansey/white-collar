import { useState } from "react";
import Register from "../components/register";
import { Box, Divider, Paper, Stack, styled } from "@mui/material";
import Login from "../components/login";

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === "dark" ? "#1A2027" : "#fff",
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: "center",
  color: "#5964E0",
  boxShadow: "none",
  cursor: "pointer",
  margin: "0px !important",
}));

const Home = () => {
  const [isRegistering, setIsRegistering] = useState(true);

  return (
    <Box
      my={4}
      display="flex"
      flexDirection="column"
      alignItems="center"
      gap={4}
      p={2}
    >
      <Stack
        direction="row"
        divider={
          <Divider
            orientation="vertical"
            flexItem
            sx={{
              bgcolor: "#5964E0",
              margin: "0px !important",
              borderBottomWidth: "15px",
            }}
          />
        }
        spacing={2}
      >
        <Item onClick={() => setIsRegistering(false)}>LOGIN</Item>

        <Item onClick={() => setIsRegistering(true)}>REGISTER</Item>
      </Stack>
      {isRegistering ? (
        <Register setIsRegistering={setIsRegistering} />
      ) : (
        <Login />
      )}
    </Box>
  );
};

export default Home;
