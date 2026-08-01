import { Card, CardContent, Typography, Box } from "@mui/material";

function StatCard({ title, value, color }) {
  return (
    <Card
      sx={{
        background: "#111827",
        borderRadius: "16px",
        color: "#fff",
        boxShadow: "0 8px 20px rgba(0,0,0,0.25)",
        transition: "0.3s",
        "&:hover": {
          transform: "translateY(-5px)",
        },
      }}
    >
      <CardContent>
        <Typography
          variant="body2"
          sx={{ color: "#9CA3AF", mb: 1 }}
        >
          {title}
        </Typography>

        <Box display="flex" alignItems="center" justifyContent="space-between">
          <Typography
            variant="h4"
            fontWeight="bold"
          >
            {value}
          </Typography>

          <Box
            sx={{
              width: 14,
              height: 14,
              borderRadius: "50%",
              bgcolor: color,
            }}
          />
        </Box>
      </CardContent>
    </Card>
  );
}

export default StatCard;