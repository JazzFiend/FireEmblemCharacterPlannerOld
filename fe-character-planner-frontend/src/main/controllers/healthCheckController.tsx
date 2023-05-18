import React = require('react');
import { useAsync } from 'react-async';
import HealthCheck from '../view/HealthCheck';
import { HealthCheckCall } from '../boundary/HealthCheckCall';

export default function HealthCheckController({ healthCheck }: { healthCheck: HealthCheckCall }) {
  function getHealthCheck(): string {
    const { data, error, isPending } = useAsync({ promiseFn: healthCheck.requestHealthCheck });
    let healthCheckResult = '';

    if (isPending) {
      healthCheckResult = 'Loading...';
    } else if (error) {
      healthCheckResult = `Something went wrong: ${error.message}`;
    } else if (data === undefined) {
      healthCheckResult = 'Promise Was null';
    } else {
      healthCheckResult = data;
    }
    return healthCheckResult;
  }

  return (
    <HealthCheck
      healthCheckText={getHealthCheck()}
    />
  );
}
