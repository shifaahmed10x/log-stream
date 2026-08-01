import { ListItemButton, ListItemIcon, ListItemText } from "@mui/material";
import { NavLink } from "react-router-dom";

function SidebarItem({ title, to, icon }) {
  return (
    <ListItemButton
      component={NavLink}
      to={to}
      sx={{
        color: "#F9FAFB",
        borderRadius: "12px",
        mb: 1,
        py: 1.2,

        "&.active": {
          bgcolor: "#0F766E",
          color: "#fff",
        },

        "&:hover": {
          bgcolor: "#1F2937",
        },
      }}
    >
      <ListItemIcon
        sx={{
          color: "inherit",
          minWidth: 40,
        }}
      >
        {icon}
      </ListItemIcon>

      <ListItemText primary={title} />
    </ListItemButton>
  );
}

export default SidebarItem;