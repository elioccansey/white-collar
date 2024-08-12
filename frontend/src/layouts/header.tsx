import { styled } from "@mui/material";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <Wrapper>
      <Link to="/" style={{ textDecoration: "none", color: "white" }}>
        White Collar Jobs
      </Link>
    </Wrapper>
  );
};

export default Header;

const Wrapper = styled("header")({
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
  width: "100%",
  height: "160px",
  backgroundColor: "#5964E0",
  color: "white",
  fontWeight: "bold",
  fontSize: "40px",
});
