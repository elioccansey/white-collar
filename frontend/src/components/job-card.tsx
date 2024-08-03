import { JobListingType } from "../types/types";

type JobCardProps = JobListingType;

const JobCard = ({
  company,
  logoURL,
  publishedDate,
  title,
  location,
}: JobCardProps) => {
  return (
    <div className="w-[20.4375rem] md:w-96 bg-white rounded-md px-8 pb-8 mt-12">
      <div className="w-12 h-12 rounded-md bg-blue-dark  -translate-y-1/2">
        <img src={logoURL} alt="Logo" />
      </div>
      <span className="text-gray text-base"> {publishedDate} </span>
      <h2 className="text-blue-dark">{title}</h2>
      <p className="text-gray text-base">{company}</p>
      <p className="text-violet text-base pt-8">{location}</p>
    </div>
  );
};

export default JobCard;
