import { Box, Button, Input } from "@mui/material";

type SearchBarProps = {
  className?: string;
};

const SearchBar = ({}: SearchBarProps) => {
  return (
    <Box
      sx={{
        width: "80%",
        display: "flex",
        gap: "20px",
        alignItems: "center",
        height: "60px",
        marginTop: "30px",
      }}
    >
      <input
        style={{
          display: "block",
          height: "60px",
          backgroundColor: "white",
          color: "#6E8098",
          outline: "none",
          border: "none",
          borderRadius: "10px",
          padding: "20px",
          width: "100%",
        }}
        type="search"
        placeholder="Search by title"
      />
      <Button
        sx={{
          height: "100%",
          width: "",
          backgroundColor: "#5964E0",
          color: "white",
          paddingInline: "40px",
          ":hover": {
            backgroundColor: "#5964E0",
          },
        }}
      >
        Search
      </Button>
    </Box>
  );
};

export default SearchBar;
