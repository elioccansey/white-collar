package cs425.whitecollar.model.job;

import cs425.whitecollar.model.application.ApplicationRepository;
import cs425.whitecollar.model.employer.dto.EmployerResponseDTO;
import cs425.whitecollar.model.job.dto.*;
import cs425.whitecollar.model.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class JobServiceImplTest {

    @Mock
    private JobRepository jobRepository;

    @Mock
    private JobResponseDTOMapper jobResponseDTOMapper;

    @Mock
    private JobRequestDTOMapper jobRequestDTOMapper;

    @Mock
    private JobRequestToJobDTOMapper jobRequestToJobDTOMapper;

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private JobServiceImpl jobService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllJobs_shouldReturnJobResponseDTOs() {

        List<Job> jobs = Arrays.asList(new Job(), new Job());
        List<JobResponseDTO> jobResponseDTOs = Arrays.asList(
                new JobResponseDTO(1, "Job Title 1", "Location 1", 3.0, 60000,
                        List.of("Java", "Spring"), List.of("Communication"), List.of("Health insurance"), new EmployerResponseDTO(1, "John","Info")),
                new JobResponseDTO(2, "Job Title 2", "Location 2", 5.0, 80000,
                        List.of("Python", "Django"), List.of("Teamwork"), List.of("Stock options"), new EmployerResponseDTO(1, "John","Info"))
        );

        when(jobRepository.findAll()).thenReturn(jobs);
        when(jobResponseDTOMapper.apply(jobs.get(0))).thenReturn(jobResponseDTOs.get(0));
        when(jobResponseDTOMapper.apply(jobs.get(1))).thenReturn(jobResponseDTOs.get(1));


        Collection<JobResponseDTO> result = jobService.getAllJobs();


        assertEquals(jobs.size(), result.size());
        assertTrue(result.containsAll(jobResponseDTOs));
        verify(jobRepository).findAll();
        verify(jobResponseDTOMapper, times(jobs.size())).apply(any(Job.class));
    }

    @Test
    void getJobById_whenJobExists_shouldReturnJobResponseDTO() {

        Job job = new Job();
        JobResponseDTO expectedResponseDTO = new JobResponseDTO(
                1, "Job Title", "Location", 3.0, 60000,
                List.of("Java", "Spring"), List.of("Communication"), List.of("Health insurance"), new EmployerResponseDTO(1, "John","Info")
        );

        when(jobRepository.findById(1L)).thenReturn(Optional.of(job));
        when(jobResponseDTOMapper.apply(job)).thenReturn(expectedResponseDTO);


        Optional<JobResponseDTO> result = jobService.getJobById(1L);


        assertTrue(result.isPresent());
        assertEquals(expectedResponseDTO, result.get());
        verify(jobRepository).findById(1L);
        verify(jobResponseDTOMapper).apply(job);
    }

    @Test
    void getJobById_whenJobDoesNotExist_shouldReturnEmpty() {

        when(jobRepository.findById(1L)).thenReturn(Optional.empty());


        Optional<JobResponseDTO> result = jobService.getJobById(1L);


        assertFalse(result.isPresent());
        verify(jobRepository).findById(1L);
        verify(jobResponseDTOMapper, never()).apply(any());
    }

    @Test
    void addJob_shouldSaveJobAndReturnJobResponseDTO() {

        JobRequestDTO jobRequestDTO = new JobRequestDTO("New Job");
        Job job = new Job();
        JobResponseDTO expectedResponseDTO = new JobResponseDTO(
                1, "Job Title", "Location", 3.0, 60000,
                List.of("Java", "Spring"), List.of("Communication"), List.of("Health insurance"), new EmployerResponseDTO(1, "John","Info")
        );

        when(jobRequestToJobDTOMapper.apply(jobRequestDTO)).thenReturn(job);
        when(jobRepository.save(job)).thenReturn(job);
        when(jobResponseDTOMapper.apply(job)).thenReturn(expectedResponseDTO);


        JobResponseDTO result = jobService.addJob(jobRequestDTO);


        assertNotNull(result);
        assertEquals(expectedResponseDTO, result);
        verify(jobRequestToJobDTOMapper).apply(jobRequestDTO);
        verify(jobRepository).save(job);
        verify(jobResponseDTOMapper).apply(job);
    }

    @Test
    void delete_whenJobExists_shouldReturnJobResponseDTO() {

        Job job = new Job();
        JobResponseDTO expectedResponseDTO = new JobResponseDTO(
                1, "Job Title", "Location", 3.0, 60000,
                List.of("Java", "Spring"), List.of("Communication"), List.of("Health insurance"), new EmployerResponseDTO(1, "John","Info")
        );

        when(jobRepository.findById(1L)).thenReturn(Optional.of(job));
        when(jobResponseDTOMapper.apply(job)).thenReturn(expectedResponseDTO);


        Optional<JobResponseDTO> result = jobService.delete(1L);


        assertTrue(result.isPresent());
        assertEquals(expectedResponseDTO, result.get());
        verify(jobRepository).findById(1L);
        verify(jobRepository).deleteById(1L);
        verify(jobResponseDTOMapper).apply(job);
    }

    @Test
    void delete_whenJobDoesNotExist_shouldReturnEmpty() {

        when(jobRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<JobResponseDTO> result = jobService.delete(1L);

        assertFalse(result.isPresent());
        verify(jobRepository).findById(1L);
        verify(jobRepository, never()).deleteById(anyLong());
    }



}
