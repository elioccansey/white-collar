import { Link } from "react-router-dom";
import jobListingsData from "../data";
import JobCard from "./job-card";
import SearchBar from "./search-bar";

const JobListings = () => {
  return (
    <>
      <div>
        <SearchBar />

        <div className="">
          {jobListingsData.map(
            ({
              id,
              company,
              location,
              salary,
              logoURL,
              publishedDate,
              title,
            }) => (
              <Link to={`joblistings/${id}`}>
                <JobCard
                  salary={salary}
                  id={id}
                  company={company}
                  logoURL={logoURL}
                  publishedDate={publishedDate}
                  title={title}
                  key={id}
                  location={location}
                />
              </Link>
            )
          )}
        </div>
      </div>
    </>
  );
};

export default JobListings;
