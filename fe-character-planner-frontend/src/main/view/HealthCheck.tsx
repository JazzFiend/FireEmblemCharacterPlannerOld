import * as React from 'react';

export default function HealthCheck({ healthCheckText }: { healthCheckText?: string }) {
  return (
      <div>
        <strong>Text:</strong>
        <pre>{healthCheckText}</pre>
      </div>
  );
}
