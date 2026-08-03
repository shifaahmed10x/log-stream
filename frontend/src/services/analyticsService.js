import api from "./api";

export const getLogLevelCount = async () => {
  const response = await api.get("/analytics/log-level-count");
  return response.data;
};

export const getApplicationCount = async () => {
  const response = await api.get("/analytics/application-count");
  return response.data;
};

export const getLogsPerDay = async () => {
  const response = await api.get("/analytics/logs-per-day");
  return response.data;
};