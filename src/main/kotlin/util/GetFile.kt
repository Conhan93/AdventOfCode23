package util

import java.nio.file.Paths
import kotlin.streams.asSequence

fun getFile(fileName: String) = Thread
    .currentThread()
    .contextClassLoader.
    getResource(fileName)?.let { Paths.get(it.toURI()).toFile() }?.inputStream()

fun <T> runChallenge(challengeInput: String, challengeSolution: (Sequence<String>) -> T): T? {
    return getFile(challengeInput)?.bufferedReader()?.use { reader -> challengeSolution(reader.lines().asSequence()) }
}