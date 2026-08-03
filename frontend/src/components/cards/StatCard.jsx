import { Box, Typography } from "@mui/material";

import GlassCard from "./GlassCard";

function StatCard({
  title,
  value,
  color,
  icon,
}) {
  return (
    <GlassCard>
      <Box
        display="flex"
        justifyContent="space-between"
        alignItems="center"
      >
        <Box>

          <Typography
            color="text.secondary"
            fontSize={14}
          >
            {title}
          </Typography>

          <Typography
            mt={1}
            fontWeight={700}
            fontSize={34}
          >
            {value}
          </Typography>

        </Box>

        <Box
          sx={{
            width: 58,
            height: 58,
            borderRadius: 4,
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            bgcolor: `${color}22`,
            color: color,
          }}
        >
          {icon}
        </Box>

      </Box>
    </GlassCard>
  );
}

export default StatCard;