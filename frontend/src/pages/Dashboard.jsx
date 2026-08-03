import DashboardHero from "../components/cards/DashboardHero";
import { Typography, Box } from "@mui/material";
import { useEffect, useState } from "react";

import {
  Activity,
  CircleAlert,
  TriangleAlert,
  Info,
} from "lucide-react";

import StatCard from "../components/cards/StatCard";
import GlassCard from "../components/cards/GlassCard";

import RecentLogsTable from "../components/tables/RecentLogsTable";
import LogLevelChart from "../components/charts/LogLevelChart";
import LogsTimelineChart from "../components/charts/LogsTimelineChart";

import { searchLogs } from "../services/logService";

function Dashboard() {
  const [searchResponse, setSearchResponse] = useState(null);

  useEffect(() => {
    loadLogs();
  }, []);

  const loadLogs = async () => {
    try {
      const data = await searchLogs({
        keyword: "",
        applicationName: "",
        serviceName: "",
        hostName: "",
        logLevel: "",
        loggerName: "",
        threadName: "",
        startDate: null,
        endDate: null,
        page: 0,
        pageSize: 10,
        sortBy: "timestamp",
        sortDirection: "desc",
      });

      setSearchResponse(data);
    } catch (error) {
      console.error(error);
    }
  };

  const logs = searchResponse?.logs || [];

  const errorCount = logs.filter(
    (log) => log.logLevel === "ERROR"
  ).length;

  const warningCount = logs.filter(
    (log) => log.logLevel === "WARN"
  ).length;

  const infoCount = logs.filter(
    (log) => log.logLevel === "INFO"
  ).length;

  return (
    <>
      <DashboardHero
          totalLogs={searchResponse?.totalRecords ?? 0}
      />

      {/* Stats */}

      <Box
        sx={{
          display: "grid",
          gridTemplateColumns: {
            xs: "1fr",
            md: "repeat(4,1fr)",
          },
          gap: 3,
        }}
      >
        <StatCard
          title="Total Logs"
          value={searchResponse?.totalRecords ?? 0}
          color="#7C3AED"
          icon={<Activity size={24} />}
        />

        <StatCard
          title="Errors"
          value={errorCount}
          color="#EF4444"
          icon={<CircleAlert size={24} />}
        />

        <StatCard
          title="Warnings"
          value={warningCount}
          color="#F59E0B"
          icon={<TriangleAlert size={24} />}
        />

        <StatCard
          title="Info"
          value={infoCount}
          color="#10B981"
          icon={<Info size={24} />}
        />
      </Box>

      {/* Recent Logs */}

      <Box mt={4}>
        <GlassCard>
          <RecentLogsTable logs={logs} />
        </GlassCard>
      </Box>

      {/* Charts */}

      <Box
        mt={4}
        sx={{
          display: "grid",
          gridTemplateColumns: {
            xs: "1fr",
            md: "1fr 1fr",
          },
          gap: 3,
        }}
      >
        <GlassCard>
          <Typography
            variant="h6"
            sx={{
              mb: 3,
              fontWeight: 600,
            }}
          >
            Log Level Distribution
          </Typography>

          <LogLevelChart />
        </GlassCard>

        <GlassCard>
          <Typography
            variant="h6"
            sx={{
              mb: 3,
              fontWeight: 600,
            }}
          >
            Log Volume Timeline
          </Typography>

          <LogsTimelineChart />
        </GlassCard>
      </Box>
    </>
  );
}

export default Dashboard;