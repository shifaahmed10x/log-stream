import { Outlet } from "react-router-dom";
import { Box } from "@mui/material";

import Sidebar from "../components/sidebar/Sidebar";
import Navbar from "../components/navbar/Navbar";

function MainLayout() {
  return (
    <Box
      sx={{
        display: "flex",
        minHeight: "100vh",

        bgcolor: "background.default",

        position: "relative",

        overflow: "hidden",
      }}
    >
      {/* Purple Glow */}

      <Box
        sx={{
          position: "fixed",

          top: -200,

          right: -150,

          width: 500,

          height: 500,

          borderRadius: "50%",

          background:
            "radial-gradient(circle,#8B5CF655,transparent 70%)",

          filter: "blur(140px)",

          pointerEvents: "none",

          zIndex: 0,
        }}
      />

      {/* Green Glow */}

      <Box
        sx={{
          position: "fixed",

          bottom: -250,

          left: -150,

          width: 450,

          height: 450,

          borderRadius: "50%",

          background:
            "radial-gradient(circle,#14B8A633,transparent 70%)",

          filter: "blur(150px)",

          pointerEvents: "none",

          zIndex: 0,
        }}
      />

      {/* Sidebar */}

      <Box
        sx={{
          zIndex: 2,
        }}
      >
        <Sidebar />
      </Box>

      {/* Main Content */}

      <Box
        sx={{
          flex: 1,

          minHeight: "100vh",

          position: "relative",

          zIndex: 1,
        }}
      >
        <Navbar />

        <Box
          sx={{
            p: 4,
          }}
        >
          <Outlet />
        </Box>
      </Box>
    </Box>
  );
}

export default MainLayout;