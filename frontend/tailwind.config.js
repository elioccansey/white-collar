/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {},
    fontFamily: {
      sans: ["Kumbh-Sans", "sans-serif"],
    },
    colors: {
      violet: {
        DEFAULT: "hsl(235, 69%, 61%)",
        light: "hsl(235, 82%, 77%)",
      },
      gray: {
        DEFAULT: "hsl(212, 23%, 69%)",
        light: "hsl(210, 22%, 96%)",
        dark: "hsl(214, 17%, 51%)",
      },
      blue: {
        dark: "hsl(219, 29%, 14%)",
        midnight: "hsl(220, 29%, 10%)",
      },
      white: "hsl(0, 0%, 100%)",
    },
    screens: {
      md: "768px",
      lg: "1440px",
    },
    fontSize: {
      sm: ["0.875rem", { lineHeight: "1.125rem" }],
      base: ["1rem", { lineHeight: "1.625rem" }],
      lg: ["1.25rem", { lineHeight: "1.5rem" }],
      xl: ["1.5rem", { lineHeight: "1.8125rem" }],
      "2xl": ["1.75rem", { lineHeight: "2.125rem" }],
    },
  },
  plugins: [],
};
