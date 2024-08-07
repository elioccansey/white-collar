import { Link } from "react-router-dom";

const Header = () => {
  return (
    <header>
      <Link to="/">
        <p>Header</p>
      </Link>
    </header>
  );
};

export default Header;
