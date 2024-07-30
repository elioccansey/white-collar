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
      sm: 375,
      md: 768,
      lg: 1440,
    },
    fontSize: {
      sm: ["14px", { lineHeight: "18px" }],
      base: ["16px", { lineHeight: "26px" }],
      lg: ["20px", { lineHeight: "24px" }],
      xl: ["24px", { lineHeight: "29px" }],
      "2xl": ["28px", { lineHeight: "34px" }],
    },
  },
  plugins: [],
};
