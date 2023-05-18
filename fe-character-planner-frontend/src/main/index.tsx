import * as React from 'react';
import * as ReactDOM from 'react-dom';
import HealthCheckController from './controllers/healthCheckController';
import HealthCheckCallAPI from './boundary/HealthCheckCallAPI';

const Index = () => (
  <HealthCheckController
    healthCheck={new HealthCheckCallAPI()}
  />
);

ReactDOM.render(<Index />, document.getElementById('root'));
