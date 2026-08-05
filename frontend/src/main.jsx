import React from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import App from './App';
import './styles.css';

class AppErrorBoundary extends React.Component {
  constructor(props) { super(props); this.state = { error: null }; }
  static getDerivedStateFromError(error) { return { error }; }
  render() {
    if (this.state.error) return <main style={{ padding: '40px', fontFamily: 'system-ui' }}><h1>Health Connect could not load</h1><p>{this.state.error.message}</p><button onClick={() => window.location.reload()}>Reload</button></main>;
    return this.props.children;
  }
}

createRoot(document.getElementById('root')).render(
  <AppErrorBoundary><BrowserRouter><App /></BrowserRouter></AppErrorBoundary>
);
