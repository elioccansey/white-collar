import { Link } from "react-router-dom";
import jobListingsData from "../data";
import JobCard from "./job-card";

const JobListings = () => {
  return (
    <div className="w-full flex flex-wrap md:gap-3 lg:gap-8 justify-center">
      {jobListingsData.map(
        ({ id, company, location, logoURL, publishedDate, title }) => (
          <Link to={`joblistings/${id}`}>
            <JobCard
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
  );
};

export default JobListings;
