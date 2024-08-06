import { Link } from "react-router-dom";

const Header = () => {
  return (
    <header className="h-32 bg-violet text-white font-bold">
      <Link to="/">
        <p className="text-2xl flex justify-center pt-8">WhiteCollar</p>
      </Link>
    </header>
  );
};

export default Header;
