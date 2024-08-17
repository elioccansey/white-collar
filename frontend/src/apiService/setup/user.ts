type data = {
  token: string,
  user: {
      userId: number,
      firstName: string,
      lastName: string,
      role: string
  }
}
export function setUser(user: data | '') {
    localStorage.setItem('user', JSON.stringify(user));
  }
  
  export function checkTokens() {
    const tokens = getUser();
  
    if (tokens.user === '') {
      return;
    }
  
    setUser(JSON.parse(tokens.user));
  }
  export function getUser() {
    return {
      user: localStorage.getItem('user') || '',
    };
  }
  