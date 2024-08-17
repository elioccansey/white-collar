import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.tsx";
import "./index.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from "./pages/home-page.tsx";
import JobListingsPage from "./pages/job-listings-page.tsx";
import EmployerJobListingsPage from "./pages/employer-job-listings-page.tsx";

const routes = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      { path: "/", element: <Home /> },
      { path: "job-listings", element: <JobListingsPage /> },
      {
        path: "job-listings-employer/:id",
        element: <EmployerJobListingsPage />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <RouterProvider router={routes} />
  </React.StrictMode>
);
