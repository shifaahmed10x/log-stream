import { Box, Chip, Typography } from "@mui/material";

import GlassCard from "./GlassCard";

import { Activity } from "lucide-react";

function DashboardHero({ totalLogs }) {
  return (
    <GlassCard
      sx={{
        mb: 4,
        overflow: "hidden",
        position: "relative",
      }}
    >
      {/* Background Glow */}

      <Box
        sx={{
          position: "absolute",
          width: 300,
          height: 300,
          right: -80,
          top: -100,

          borderRadius: "50%",

          background:
            "radial-gradient(circle,#7C3AED55,transparent 70%)",

          filter: "blur(40px)",
        }}
      />

      <Typography
        variant="h4"
        fontWeight={700}
      >
        Welcome back 👋
      </Typography>

      <Typography
        mt={1}
        color="text.secondary"
      >
        Monitor, search and analyze distributed application logs in real time.
      </Typography>

      <Box
        mt={4}
        display="flex"
        gap={2}
        flexWrap="wrap"
      >
        <Chip
          color="success"
          icon={<Activity size={16} />}
          label="● Healthy"
        />

        <Chip
          label={`${totalLogs} Logs Indexed`}
        />

        <Chip
          label="WebSocket Connected"
        />

        <Chip
          label="Lucene Indexed"
        />
      </Box>
    </GlassCard>
  );
}

export default DashboardHero;