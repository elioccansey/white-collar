type SearchBarProps = {
  className?: string;
};

const SearchBar = ({ className }: SearchBarProps) => {
  return (
    <div>
      <input type="search" name="search" id="" />
    </div>
  );
};

export default SearchBar;
