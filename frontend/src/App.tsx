import { Outlet } from "react-router";
import Header from "./layouts/header";

function App() {
  return (
    <div className="bg-gray-light">
      <Header />
      <Outlet />
    </div>
  );
}

export default App;
