import { JobListingType } from "../types/types";

type JobCardProps = JobListingType;

const JobCard = ({ company, salary, title, location }: JobCardProps) => {
  return (
    <div>
      <p>{company}</p>
      <p> {salary} </p>
      <h2>{title}</h2>
      <p>{location}</p>
    </div>
  );
};

export default JobCard;
