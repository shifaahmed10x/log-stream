import { Box, Typography, List } from "@mui/material";

import {
  LayoutDashboard,
  Search,
  BarChart3,
  Terminal,
  Sparkles,
} from "lucide-react";

import SidebarItem from "./SidebarItem";

function Sidebar() {
  return (
    <Box
      sx={{
        width: 280,
        minHeight: "100vh",

        display: "flex",
        flexDirection: "column",

        background: "rgba(18,18,18,.75)",
        backdropFilter: "blur(20px)",

        borderRight: "1px solid rgba(255,255,255,.06)",

        px: 3,
        py: 4,
      }}
    >
      {/* Logo */}

      <Box
        sx={{
          display: "flex",
          alignItems: "center",
          gap: 1.5,
          mb: 5,
        }}
      >
        <Box
          sx={{
            width: 42,
            height: 42,
            borderRadius: "14px",

            display: "flex",
            justifyContent: "center",
            alignItems: "center",

            background:
            "linear-gradient(135deg,#8B5CF6,#A855F7)",

            boxShadow:
            "0 12px 35px rgba(139,92,246,.35)",
          }}
        >
          <Sparkles size={20} color="white" />
        </Box>

        <Box>
          <Typography
            sx={{
              fontWeight: 700,
              fontSize: 20,
              color: "text.primary",
            }}
          >
            LogStream
          </Typography>

          <Typography
            sx={{
              fontSize: 12,
              color: "text.secondary",
            }}
          >
            Distributed Analytics
          </Typography>
        </Box>
      </Box>

      <List
        sx={{
          display: "flex",
          flexDirection: "column",
          gap: 1,
        }}
      >
        <SidebarItem
          title="Dashboard"
          to="/"
          icon={<LayoutDashboard size={18} />}
        />

        <SidebarItem
          title="Search Logs"
          to="/search"
          icon={<Search size={18} />}
        />

        <SidebarItem
          title="Analytics"
          to="/analytics"
          icon={<BarChart3 size={18} />}
        />

        <SidebarItem
          title="Live Tail"
          to="/live-tail"
          icon={<Terminal size={18} />}
        />
      </List>

      <Box sx={{ flexGrow: 1 }} />

      <Typography
        sx={{
          textAlign: "center",
          color: "text.secondary",
          fontSize: 12,
          opacity: 0.55,
        }}
      >
        LogStream v1.0
      </Typography>
    </Box>
  );
}

export default Sidebar;