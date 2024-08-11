export function setTokens(accessToken = '') {
    localStorage.setItem('access-token', accessToken);
  }
  
  export function checkTokens() {
    const tokens = getTokens();
  
    if (tokens.accessToken === '') {
      return;
    }
  
    setTokens();
  }
  export function getTokens() {
    return {
      accessToken: localStorage.getItem('access-token') || '',
    };
  }
  