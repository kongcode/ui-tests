package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;
import io.kongcode.uitests.api.TestCaseService;
import io.kongcode.uitests.api.dto.TestCaseSearchResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by joao on 05/03/16.
 */
public class TestCaseServiceTest {

    private TestCaseService service;
    private TestCaseRepository repository;

    @Before public void setUp() throws Exception {
        this.repository = mock(TestCaseRepository.class);
        this.service = new TestCaseServiceImpl(repository);
    }

    @Test public void testCreate() throws Exception {
        TestCase entity = TestCase.builder().build();
        TestCase.TestCaseBuilder builder = mock(TestCase.TestCaseBuilder.class);

        when(repository.save(entity)).thenReturn(entity);
        when(builder.build()).thenReturn(entity);

        assertEquals(entity, service.create(builder));
        verify(repository).save(entity);
    }

    @Test public void testFindAll() throws Exception {
        int id = 1;
        String name = "Test";
        TestCase testCase = TestCase.builder().withId(id).withName(name).build();
        when(repository.streamAll()).thenReturn(Stream.of(testCase));
        List<TestCaseSearchResult> expected = Arrays.asList(new TestCaseSearchResult(id, name));
        Stream<TestCaseSearchResult> actual = service.findAll();
        assertEquals(expected, actual.collect(toList()));
    }
}
