import { Box, Typography, Divider, List } from "@mui/material";

import {
  LayoutDashboard,
  Search,
  BarChart3,
  Terminal,
  Settings,
} from "lucide-react";

import SidebarItem from "./SidebarItem";

function Sidebar() {
  return (
    <Box
      sx={{
        width: 270,
        minHeight: "100vh",
        bgcolor: "#111827",
        borderRight: "1px solid #1F2937",
        px: 2,
        py: 3,
      }}
    >
      {/* Logo */}

      <Typography
        variant="h5"
        fontWeight="bold"
        color="white"
        sx={{
          px: 2,
          mb: 3,
        }}
      >
        Log Stream
      </Typography>

      <Divider sx={{ bgcolor: "#374151", mb: 3 }} />

      <List>

        <SidebarItem
          title="Dashboard"
          to="/"
          icon={<LayoutDashboard size={20} />}
        />

        <SidebarItem
          title="Search Logs"
          to="/search"
          icon={<Search size={20} />}
        />

        <SidebarItem
          title="Analytics"
          to="/analytics"
          icon={<BarChart3 size={20} />}
        />

        <SidebarItem
          title="Live Tail"
          to="/live-tail"
          icon={<Terminal size={20} />}
        />

        <SidebarItem
          title="Settings"
          to="/settings"
          icon={<Settings size={20} />}
        />

      </List>
    </Box>
  );
}

export default Sidebar;