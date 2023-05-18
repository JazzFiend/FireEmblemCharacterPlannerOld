export interface HealthCheckCall {
  requestHealthCheck(): Promise<string>;
}
