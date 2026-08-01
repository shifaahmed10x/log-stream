import { Outlet } from "react-router-dom";
import { Box } from "@mui/material";

import Sidebar from "../components/sidebar/Sidebar";
import Navbar from "../components/navbar/Navbar";

function MainLayout() {
  return (
    <Box
      sx={{
        display: "flex",
        width: "100%",
        minHeight: "100vh",
      }}
    >
      <Sidebar />

      <Box
        sx={{
          flex: 1,
          background: "#0B1120",
          minHeight: "100vh",
        }}
      >
        <Navbar />

        <Box p={4}>
          <Outlet />
        </Box>
      </Box>
    </Box>
  );
}

export default MainLayout;