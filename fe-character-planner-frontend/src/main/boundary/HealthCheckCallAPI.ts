import { HealthCheckCall } from './HealthCheckCall';

export default class HealthCheckCallAPI implements HealthCheckCall {
  public async requestHealthCheck(): Promise<string> {
    return HealthCheckCallAPI.getRequest('http://localhost:8080/api/healthCheck/');
  }

  public static async getRequest(uri: string): Promise<string> {
    const res = await fetch(uri, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    if (!res.ok) throw new Error(res.statusText);
    return res.text();
  }
}
